clear all

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


Y = data2(:,1);

stem(Y);

xlabel('angle (Theta)');
ylabel('RCS (V) (dBsm)');
title('Farfield RCS');

