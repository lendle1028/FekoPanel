clear

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%pathname='d:\ravis\output\';        %assign  path of rcs data file
% Header_l=101;                            %assign  length of FILE_header
% Column_n=9;                              %assign  number of column
Freqnum=1;                              %assign Freq. number
Freqitem=1;                             %assign Freq. item you want.
% Header_l2=0;                            %assign  length of FILE_header
% Column_n2=2;                              %assign  number of column
% Header_l3=1;                            %assign  length of FILE_header
% Column_n3=3;                              %assign  number of column
Header_l3=101;                            
Column_n3=9;

dxmax=15;              %assign  X / Y SCALE for D_plot
dxmin=-45;
dxstep=5;
dxspan=dxmax-dxmin;

dymax=100;
dymin=0;
dystep=5;
dyspan=dymax-dymin;

%titlestr='RCS of V01MDL by RAVIS';             %assign  TITLE
%titlestr='RCS';             %assign  TITLE

%ylbl='';                     %assign  LABEL
%xlbl='RCS (dBsm)';

%txt1='\theta:90 deg';
%txt1='\theta:1 deg/step ';
%txt2='\phi:1 deg/step';
%txt3=' S band ';
txt3='场家览翴计180901';
%txt4=' RAVIS '; % 3 bounces';
%txt5='  red  : Mean in 5 deg. window';

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%filename17='933-after-all-4obj-10dB-V1fre9_the02_4360POSBR2d_3bounces.txt';
filename0001='B2NEcsh2D3060_sphere_9.4GHz_0.1m_FMM.rcs';  %郎┾传%
filename0002='B2NEcsh2D3060PO.rcs';  %郎┾传%
%filename0003='5-3.txt';

[data]=rcsfdata(filename0001,Header_l3,Column_n3);   %input rcs data
data1=data(:,2);
data2=data(:,3);
data3=data(:,6);
data4=data(:,9);
[lm,ln]=size(data1);
phi0001=data2(Freqitem:Freqnum:lm);
vv0001=data3(Freqitem:Freqnum:lm);
hh0001=data4(Freqitem:Freqnum:lm);

sizedata=size(data3);

[data]=rcsfdata(filename0002,Header_l3,Column_n3);   %input rcs data
data1=data(:,2);
data2=data(:,3);
data3=data(:,6);
data4=data(:,9);
[lm,ln]=size(data1);
phi0002=data2(Freqitem:Freqnum:lm);
vv0002=data3(Freqitem:Freqnum:lm);
hh0002=data4(Freqitem:Freqnum:lm);

% [data]=rcsfdata(filename0003,Header_l3,Column_n3);   %input rcs data
% data1=data(:,1);
% data2=data(:,2);
% data3=data(:,3);
% [lm,ln]=size(data1);
% phi0003=data1(Freqitem:Freqnum:lm);
% vv0003=data2(Freqitem:Freqnum:lm);
% vv0003_1=data3(Freqitem:Freqnum:lm);

% [data]=rcsfdata(filename17,Header_l2,Column_n2);   %input rcs data
% data1=data(:,1);
% data2=data(:,2);
% [lm,ln]=size(data1);
% phi17=data1(Freqitem:Freqnum:lm);
% vv17=data2(Freqitem:Freqnum:lm);

hh=figure(1);
set(hh, 'papertype','a4letter', 'paperposition',[0.25 4 8 6]);

axis('off')
axes('position',[.12 .2 .76 .65]);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
RCS=[-45:1:15];

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
[N0,RCS0]=hist(vv0001,RCS);
CDFN0=(cumsum(N0)/sizedata(1,1))*100;

[N1,RCS1]=hist(vv0002,RCS);
CDFN1=(cumsum(N1)/sizedata(1,1))*100;

% [N3,RCS3]=hist(vv17,RCS);
% CDFN3=cumsum(N3)/361;%361计家,

%[N0,RCS0]=hist(vv02,RCS);
%CDFN0=cumsum(N0)/361;
%[N1,RCS1]=hist(vv07,RCS);
%CDFN1=cumsum(N1)/361;

%[N0,RCS0]=hist(vv08,RCS);
%CDFN0=cumsum(N0)/361;
%[N1,RCS1]=hist(vv09,RCS);
%CDFN1=cumsum(N1)/361;

%[N0,RCS0]=hist(vv10,RCS);
%CDFN0=cumsum(N0)/361;
%[N1,RCS1]=hist(vv11,RCS);
%CDFN1=cumsum(N1)/361;

%RCS_CDF_P5=interp1(0.5,SBR,CDF0);
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
x1 = RCS0;
%disp(x1);
y1 = N0;
%disp(y1);
x2 = RCS0;
%disp(x2);
y2 = CDFN0;
%disp(y2);

%disp(y2(54)*361);%163
%disp(y2(55)*361);%184

% x3 = RCS1;
% %disp(x3);
% y3 = N1;
% %disp(y3);
x4 = RCS1;
% %disp(x4);
y4 = CDFN1;
% %disp(y4);

%x5 = RCS2;
% %disp(x5);
%y5 = N2;
% %disp(y5);
%x6 = RCS2;
% %disp(x6);
%y6 = CDFN2;
% %disp(y6);

% x7 = RCS3;
% %disp(x7);
% y7 = N3;
% %disp(y7);
% x8 = RCS3;
% %disp(x8);
% y8 = CDFN3;
% %disp(y8);


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
bar1=bar(RCS0,N0,'b');
%alpha(.5);
set(bar1,'BarWidth',0.6);
hold on;
bar2=bar(RCS1,N1,'m');
set(bar2,'BarWidth',0.4);
hold on;
%bar3=bar(RCS2,N2,'g');
%set(bar3,'BarWidth',0.2);
% hold on;
% bar4=bar(RCS3,N3,'k');
% set(bar4,'BarWidth',0.1);
% hold on;

ax1 = gca;

xlabel('RCS(dBsm)');
ylabel('Quantity');

ax2 = axes('Position',get(ax1,'Position'),...
           'XAxisLocation','top',...
           'YAxisLocation','right',...
           'Color','none',...
           'XColor','k','YColor','k');
       
hl1 = line(x2,y2,'Color','b','linewidth',2,'Parent',ax2);
hold on;
hl2 = line(x4,y4,'Color','m','linewidth',2,'Parent',ax2);
hold on;
%hl3 = line(x6,y6,'Color','g','linewidth',2,'Parent',ax2);
%hold on;
% hl4 = line(x8,y8,'Color','k','linewidth',0.5,'Parent',ax2);
% hold on;

%legend('X-bandэ筿┮5-1(raw data)','X-bandэ筿┮5-2(raw data)','X-bandэ筿┮5-3(raw data)','X-bandэ计家 :∮2');
legend('Ωは甮CDF','Ωは甮CDF');
%if (y2 >= 0.5) 
%disp(x2);
%disp(y2);
%end;

%xlabel('RCS(dBsm)');
ylabel('CDF(%)');
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
xlimits1 = get(ax1,'XLim');
%disp(xlimits1);
ylimits1 = get(ax1,'YLim');
%disp(ylimits1);

% xinc1 = (xlimits1(2)-xlimits1(1))/18;
yinc1 = (ylimits1(2)-ylimits1(1))/10;
% set(ax1,'XColor','b','YColor','b');
% set(ax1,'XTick',[xlimits1(1):xinc1:xlimits1(2)],...
%         'YTick',[ylimits1(1):yinc1:ylimits1(2)]);
set(ax1,'XTick',[dxmin:dxstep:dxmax],'YTick',[ylimits1(1):yinc1:ylimits1(2)]);

% xlimits2 = get(ax2,'XLim');
ylimits2 = get(ax2,'YLim');
% xinc2 = (xlimits2(2)-xlimits2(1))/18;
yinc2 = (ylimits2(2)-ylimits2(1))/10;
% set(ax2,'XColor','k','YColor','k');
% set(ax2,'XTick',[xlimits2(1):xinc2:xlimits2(2)],...
%         'YTick',[ylimits2(1):yinc2:ylimits2(2)]);
set(ax2,'XTick',[dxmin:dxstep:dxmax],'YTick',[ylimits2(1):yinc2:ylimits2(2)]);
setxgrid(dxmin,dxstep,dxmax);
% titlestr='场家览翴计180901';
% title(titlestr,'fontsize',12,'fontweight','b');

text(dxmin-0.12*dxspan,dymin-(0.20*dyspan),txt3)
grid on;
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%title(titlestr);
%grid on;
%xlabel(xlbl);
%ylabel(ylbl);
%setxgrid(dxmin,dxstep,dxmax);
%setygrid(dymin,dystep,dymax);

%text(dxmin-(0.12*dxspan),dymin-(0.13*dyspan),txt1);
%text(dxmin-(0.12*dxspan),dymin-(0.20*dyspan),txt2);

%text(0,-0.1,txt1);
%text(0,-0.2,txt2);

%text(dxmin-(0.12*dxspan),dymin-(0.27*dyspan),txt3)
%text(dxmin+0.8*dxspan,dymin-(0.15*dyspan),txt4)
%text(dxmin+0.8*dxspan,dymin-(0.22*dyspan),txt5)



