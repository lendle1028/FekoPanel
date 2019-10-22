clear

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

Freqnum=1;                              %assign Freq. number
Freqitem=1;                             %assign Freq. item you want.

Header_l3=101;                            
Column_n3=9;

dxmax1=2;              %assign  X / Y SCALE for D_plot
dxmin1=-12;
dxstep1=2;
dxspan1=dxmax1-dxmin1;

dymax1=15;
dymin1=0;
dystep1=1;
dyspan1=dymax1-dymin1;

dxmax2=2;              %assign  X / Y SCALE for D_plot
dxmin2=-12;
dxstep2=2;
dxspan2=dxmax2-dxmin2;

dymax2=80;
dymin2=20;
dystep2=5;
dyspan2=dymax2-dymin2;

%txt3='全部模擬點數：180901';
axis('on')

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


% filename0001='e:\Alex\Ravis-U23-20050518\RCS Table\UAV0806_NoEOIR_3D.rcs';
% filename0002='e:\Alex\Ravis-U23-20050518\RCS Table\UAV0814_NonEngine_3D.rcs';
% filename0003='e:\Alex\Ravis-U23-20050518\RCS Table\UAV0819_NonEmpennage_3D.rcs';
% filename0004='e:\Alex\Ravis-U23-20050518\RCS Table\UAV0814_NonEmpAndNonEng_3D.rcs';
% filename0005='e:\Alex\Ravis-U23-20050518\RCS Table\UAV0823_wingimproved_3D.rcs';

% filename0001='e:\Alex\Ravis-U23-20050518\RCS Table\UAV0830_EOIR_normal_3D.rcs';
% filename0002='e:\Alex\Ravis-U23-20050518\RCS Table\UAV0910_EOIR_NonEngine_3D.rcs';
% filename0003='e:\Alex\Ravis-U23-20050518\RCS Table\UAV0830_EOIR_NonEmpennage_3D.rcs';
% filename0004='e:\Alex\Ravis-U23-20050518\RCS Table\UAV0830_EOIR_NonEmpAndNonEng_3D.rcs';
% filename0005='e:\Alex\Ravis-U23-20050518\RCS Table\UAV0830_EOIR_wingimproved_3D.rcs';

filename0001='e:\Alex\Ravis-U23-20050518\RCS Table\UAV0401_realoriginal_3D.rcs';
filename0002='e:\Alex\Ravis-U23-20050518\RCS Table\UAV0401_realRAM_3D.rcs';
filename0003='e:\Alex\Ravis-U23-20050518\RCS Table\UAV0324_fixaRAM_3D.rcs';

[data]=rcsfdata(filename0001,Header_l3,Column_n3);   %input rcs data
data1=data(:,2);
data2=data(:,3);
data3=data(:,6);
data4=data(:,9);
[lm,ln]=size(data1);
phi1=data2(Freqitem:Freqnum:lm);
the1=data1(Freqitem:Freqnum:lm);
vv1=data3(Freqitem:Freqnum:lm);
hh1=data4(Freqitem:Freqnum:lm);

sizedata0=size(data3);

[data]=rcsfdata(filename0002,Header_l3,Column_n3);   %input rcs data
data1=data(:,2);
data2=data(:,3);
data3=data(:,6);
data4=data(:,9);
[lm,ln]=size(data1);
phi2=data2(Freqitem:Freqnum:lm);
the2=data1(Freqitem:Freqnum:lm);
vv2=data3(Freqitem:Freqnum:lm);
hh2=data4(Freqitem:Freqnum:lm);

[data]=rcsfdata(filename0003,Header_l3,Column_n3);   %input rcs data
data1=data(:,2);
data2=data(:,3);
data3=data(:,6);
data4=data(:,9);
[lm,ln]=size(data1);
phi3=data2(Freqitem:Freqnum:lm);
the3=data1(Freqitem:Freqnum:lm);
vv3=data3(Freqitem:Freqnum:lm);
hh3=data4(Freqitem:Freqnum:lm);

% [data]=rcsfdata(filename0004,Header_l3,Column_n3);   %input rcs data
% data1=data(:,2);
% data2=data(:,3);
% data3=data(:,6);
% data4=data(:,9);
% [lm,ln]=size(data1);
% phi4=data2(Freqitem:Freqnum:lm);
% the4=data1(Freqitem:Freqnum:lm);
% vv4=data3(Freqitem:Freqnum:lm);
% hh4=data4(Freqitem:Freqnum:lm);
% 
% [data]=rcsfdata(filename0005,Header_l3,Column_n3);   %input rcs data
% data1=data(:,2);
% data2=data(:,3);
% data3=data(:,6);
% data4=data(:,9);
% [lm,ln]=size(data1);
% phi5=data2(Freqitem:Freqnum:lm);
% the5=data1(Freqitem:Freqnum:lm);
% vv5=data3(Freqitem:Freqnum:lm);
% hh5=data4(Freqitem:Freqnum:lm);




num2=1;
for num1=1:1:sizedata0(1,1)
    if ((the1(num1,1)>107)&&(the1(num1,1)<180)&&((abs(phi1(num1,1))<90)));
        vv0001(num2,1)=vv1(num1,1);
        vv0002(num2,1)=vv2(num1,1);
        vv0003(num2,1)=vv3(num1,1);
%         vv0004(num2,1)=vv4(num1,1);
%         vv0005(num2,1)=vv5(num1,1);
        num2=num2+1;
    end
end

sizedata1=size(vv0001);
sizedata2=size(vv0002);
sizedata3=size(vv0003);
% sizedata4=size(vv0004);
% sizedata5=size(vv0005);
%totalpoint=int32(sizedata1(1,1));
totalpointW=char(int2str(int32(sizedata1(1,1))));

txt3=strcat('全部模擬點數：',totalpointW);




%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
RCS=[-20:2:10];

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
[N1,RCS1]=hist(vv0001,RCS);
CDFN1=(cumsum(N1)/sizedata1(1,1))*100;

N1=(N1/sizedata1(1,1))*100;

[N2,RCS2]=hist(vv0002,RCS);
CDFN2=(cumsum(N2)/sizedata2(1,1))*100;

N2=(N2/sizedata2(1,1))*100;

[N3,RCS3]=hist(vv0003,RCS);
CDFN3=(cumsum(N3)/sizedata3(1,1))*100;

N3=(N3/sizedata3(1,1))*100;

% [N4,RCS4]=hist(vv0004,RCS);
% CDFN4=(cumsum(N4)/sizedata4(1,1))*100;
% 
% N4=(N4/sizedata4(1,1))*100;
% 
% [N5,RCS5]=hist(vv0005,RCS);
% CDFN5=(cumsum(N5)/sizedata5(1,1))*100;
% 
% N5=(N5/sizedata5(1,1))*100;
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
x1 = RCS1;
y1 = CDFN1;

x2 = RCS2;
y2 = CDFN2;

x3 = RCS3;
y3 = CDFN3;

% x4 = RCS4;
% y4 = CDFN4;
% 
% x5 = RCS5;
% y5 = CDFN5;
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
subplot(2,1,1)
bar1=bar(RCS1,N1,'b');
set(bar1,'BarWidth',0.5);
hold on;
bar2=bar(RCS2,N2,'m');
set(bar2,'BarWidth',0.4);
hold on;
bar3=bar(RCS3,N3,'g');
set(bar3,'BarWidth',0.3);
hold on;
% bar4=bar(RCS4,N4,'c');
% set(bar4,'BarWidth',0.2);
% hold on;
% bar5=bar(RCS5,N5,'r');
% set(bar5,'BarWidth',0.1);
% hold on;
ax1 = gca;

titlestr='90< \theta <180, -90< \phi <90';
((the1(num1,1)>94)&&(the1(num1,1)<96)&&((abs(phi1(num1,1))<90)));
xlabel('RCS(dBsm)','fontsize',12,'fontweight','b');
ylabel('PDF(%)','fontsize',12,'fontweight','b');

title(titlestr,'fontsize',12,'fontweight','b');

%legend('原型研改機','原型研改機+引擎空腔處理','原型研改機+垂直尾翼處理','原型研改機+引擎空腔處理+垂直尾翼處理','原型研改機+引擎空腔處理+垂直尾翼處理+水平機翼處理');
legend('原型研改機','原型研改機+引擎空腔處理','原型研改機+垂直尾翼處理')
%legend('原型研改機','原型研改機+引擎空腔處理+垂直尾翼處理','原型研改機+引擎空腔處理+垂直尾翼處理+水平機翼處理')
text(dxmin1+(0.3*dxspan1),dymax1-(0.25*dyspan1),txt3)
grid on;
setxgrid(dxmin1,dxstep1,dxmax1);
setygrid(dymin1,dystep1,dymax1);

line(RCS1,N1,'Color','b','linewidth',2);
hold on;
line(RCS2,N2,'Color','m','linewidth',2);
hold on;
line(RCS3,N3,'Color','g','linewidth',2);
hold on;
% line(RCS4,N4,'Color','c','linewidth',2);
% hold on;
% line(RCS5,N5,'Color','r','linewidth',2);
% hold on;
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
subplot(2,1,2)
hl1 = line(x1,y1,'Color','b','linewidth',2);
hold on;       
hl2 = line(x2,y2,'Color','m','linewidth',2);
hold on;
hl3 = line(x3,y3,'Color','g','linewidth',2);
hold on;
% hl4 = line(x4,y4,'Color','c','linewidth',2);
% hold on
% hl4 = line(x5,y5,'Color','r','linewidth',2);
% hold on 
%legend('0<\theta<180 deg','\theta>90 and -90< \phi <90 deg','120> \theta>90 and -60< \phi <60 deg','120> \theta>90 and -30< \phi <30 deg');
%legend('\theta>90 and -90< \phi <90 deg','120> \theta>90 and -60< \phi <60 deg','120> \theta>90 and -30< \phi <30 deg');
%legend('原型研改機','原型研改機+引擎空腔處理','原型研改機+垂直尾翼處理','原型研改機+引擎空腔處理+垂直尾翼處理','原型研改機+引擎空腔處理+垂直尾翼處理+水平機翼處理');
legend('原型研改機','原型研改機+引擎空腔處理','原型研改機+垂直尾翼處理')
%legend('原型研改機','原型研改機+引擎空腔處理+垂直尾翼處理','原型研改機+引擎空腔處理+垂直尾翼處理+水平機翼處理')
xlabel('RCS(dBsm)'); 
ylabel('CDF(%)');

grid on;
setxgrid(dxmin2,dxstep2,dxmax2);
setygrid(dymin2,dystep2,dymax2);
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%





