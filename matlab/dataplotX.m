clear

%%%%%%%%%%%%%%%%%%%%%%%%%%
%{
xlsFile='dataX.xls';
[fileType, sheets] = xlsfinfo(dataX);
%}
%%%%%%%%%%%%%%%%%%%%%%%%%

load dataX.txt;
data = load('data.txt');
data1 = load('dataX.txt');
data2 = load('dataY.txt');

%%%%%%%%%%%%%%%%%%%%%%%%%%%


Y = data1(:,1);

stem(Y);

xlabel('angle (phi)');
ylabel('RCS (U) (m^2)');
title('Farfield RCS');

