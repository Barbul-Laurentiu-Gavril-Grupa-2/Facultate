%% Incarcare Date
clc
clear
close all
load('Semnal.mat')
t = Barbul(:, 1); %timpul
u = Barbul(:, 2); %semnalul de intrare
y1 = Barbul(:, 3); %primul semnal de iesire
y2 = Barbul(:, 4); %al doilea semnal de iesire
%% Plot intrare/iesire
%Plot intrare/iesire y1
figure
plot(t, u, t, y1)
xlabel('Time')
ylabel('Amplitude')
legend('Intrare', 'Iesire fara zero' )
title('Input and Output Plot')
dcm = datacursormode(gcf);
set(dcm, 'UpdateFcn', @customCursorUpdateFcn);
%Plot intrare/iesire y2
figure
plot(t, u,t , y2)
xlabel('Time')
ylabel('Amplitude')
legend('Intrare', 'Iesire cu un zero')
title('Input and Output Plot')
dcm = datacursormode(gcf);
set(dcm, 'UpdateFcn', @customCursorUpdateFcn);
%% Identificarea sistemului pe iesirea y1 prin metoda de rezonanta
umax = 208; %punct de pe intrare cu amplitudine maxima pozitiva
umin = 190; %punct de pe intrare cu amplitudine maxima negativa
ymax = 213; %punct de pe iesirea y1 cu amplitudine maxima pozitiva
ymin = 195; %punct de pe iesirea y1 cu amplitudine maxima negativa
%% Compunerea Parametrilor
%Interval de timp
Tr = (t(ymax) - t(ymin)) * 2;
%Pulsatie de rezonanta
wr = 2 * pi / Tr;
%Timp de esantionare
dt = t(ymax) - t(umax);
%Modul rezonanta raportul
Mr = (y1(ymin) - y1(ymax)) / (u(umin) - u(umax));
%Factor de amortizare
tita = sqrt((Mr - sqrt(Mr^2 - 1)) / (2 * Mr));
%Pulsatia naturala
wn = wr / sqrt(1 - 2 * tita^2);
%Factor de proportionalitate
K = mean(y1)/mean(u);
%% Generare semnal simulat si afisare
% Crearea functiei de transfer
Hs = tf(K * wn^2, [1, 2 * tita * wn, wn^2]);
% Generare matrici pentru spatiul starilor
A = [0 1;-wn^2 -2*tita*wn];
B = [0;K*wn^2];
C = [1 0];
D = 0;
% Convertire in spatiul starilor
sys = ss(A, B, C, D);
% Generare semnal simulat
ysim1 = lsim(sys, u, t, [y1(1), (y1(2) - y1(1)) / (t(2) - t(1))]);
% Plot cu semnalul de iesire y1 si cu semnalul simulat
figure
plot(t, ysim1, t, y1)
xlabel('Time')
ylabel('Amplitude')
legend('Simulated Output', 'Actual Output')
title('System Response')
hold on
% Calcularea eroare patratica normalizata
empn = norm(y1 - ysim1) / norm(y1 - mean(y1)) * 100;
% Afisare in command valoare eroare patratica normalizata
disp(['Eroare patratica normalizata (empn): ' num2str(empn) '%']);
%% Fara Zero
%grupez intr-un singur obiect
Ta =t(2)-t(1);% timp de achizitie
d_id1 = iddata(y1,u,Ta)
%verificare ordin
n4sid(d_id1,1:10)
%% 1:Metoda validata prin autocorelatie
M1_armax = armax(d_id1,[2,1,2,1]) %intercorelatie intre iesire si zgomot
resid(d_id1,M1_armax), shg %validare autocorelatie/intercorelatie
figure
compare(d_id1,M1_armax), shg %verificare suprapunere semnal simulat
Hz_arx1 = tf(M1_armax.B,M1_armax.A,Ta,'variable','z^-1')%functia de transfer in discret
Hs_arx1 = d2c(Hz_arx1,'zoh')%functia de transfer in continu
%% 2:Metoda validata prin intercorelatie
M1_oe = oe(d_id1,[1,2,1])
resid(d_id1,M1_oe), shg %validare autocorelatie/intercorelatie
figure
compare(d_id1,M1_oe), shg %verificare suprapunere semnal simulat
Hz_oe1 = tf(M1_oe.B,M1_oe.F,Ta,'variable','z^-1')%functia de transfer in discret
Hs_oe1 = d2c(Hz_oe1,'zoh')%functia de transfer in continu
%% Cu un zero
%Grupez intr-un singur obiect
Ta =t(2)-t(1);% timp de achizitie
d_id2 = iddata(y2,u,Ta)
%verificare ordin
n4sid(d_id2,1:10)
%% 1:Metoda validata prin autocorelatie
M2_armax = armax(d_id2,[2,2,2,1]) %intercorelatie intre iesire si zgomot
resid(d_id2,M2_armax), shg %validare autocorelatie/intercorelatie
figure
compare(d_id2,M2_armax), shg %verificare suprapunere semnal simulat
Hz_arx2 = tf(M2_armax.B,M2_armax.A,Ta,'variable','z^-1')%functia de transfer in discret
Hs_arx2 = d2c(Hz_arx2,'zoh')%functia de transfer in continu
%% 2:Metoda validata prin intercorelatie
M2_iv4 = iv4(d_id2,[2 2 1]); %intercorelatie intre iesire si zgomot
resid(d_id2,M2_iv4,10), shg %validare autocorelatie/intercorelatie
figure
compare(d_id2,M2_iv4), shg %verificare suprapunere semnal simulat
Hz_iv2 = tf(M2_iv4.B,M2_iv4.A,Ta,'variable','z^-1')%functia de transfer in discret
Hs_iv2 = d2c(Hz_iv2,'zoh')%functia de transfer in continu