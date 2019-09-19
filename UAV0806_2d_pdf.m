clear

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

Freqnum=1;                              %assign Freq. number
Freqitem=1;                             %assign Freq. item you want.

Header_l3=101;                            
Column_n3=9;

dxmax1=30;              %assign  X / Y SCALE for D_plot
dxmin1=-30;
dxstep1=5;
dxspan1=dxmax1-dxmin1;

dymax1=20000;
dymin1=0;
dystep1=2000;
dyspan1=dymax1-dymin1;

dxmax2=30;              %assign  X / Y SCALE for D_plot
dxmin2=-30;
dxstep2=5;
dxspan2=dxmax2-dxmin2;

dymax2=100;
dymin2=0;
dystep2=20;
dyspan2=dymax2-dymin2;


txt3='场家览翴计180901';
axis('on')

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

filename0001='B2NEcsh2D3060_sphere_9.4GHz_0.1m_FMM.rcs';  %郎┾传%
filename0002='B2NEcsh2D3060PO.rcs';  %郎┾传%


[data]=rcsfdata(filename0001,Header_l3,Column_n3);   %input rcs data
data1=data(:,2);
data2=data(:,3);
data3=data(:,6);
data4=data(:,9);
[lm,ln]=size(data1);
phi0001=data2(Freqitem:Freqnum:lm);
vv0001=data3(Freqitem:Freqnum:lm);
hh0001=data4(Freqitem:Freqnum:lm);

sizedata1=size(data3);

[data]=rcsfdata(filename0002,Header_l3,Column_n3);   %input rcs data
data1=data(:,2);
data2=data(:,3);
data3=data(:,6);
data4=data(:,9);
[lm,ln]=size(data1);
phi0002=data2(Freqitem:Freqnum:lm);
the2=data1(Freqitem:Freqnum:lm);
vv2=data3(Freqitem:Freqnum:lm);
hh2=data4(Freqitem:Freqnum:lm);
num2=1;
num3=1;

for num1=1:1:sizedata1(1,1)
    if the2(num1,1)<90;
        vv0002(num2,1)=vv2(num1,1);
        num2=num2+1;
    else
        vv0003(num3,1)=vv2(num1,1);
        num3=num3+1;
    end
end

sizedata2=size(vv0002);
sizedata3=size(vv0003);



%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
RCS=[-30:5:30];

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
[N1,RCS1]=hist(vv0001,RCS);
CDFN1=(cumsum(N1)/sizedata1(1,1))*100;

[N2,RCS2]=hist(vv0002,RCS);
CDFN2=(cumsum(N2)/sizedata2(1,1))*100;

[N3,RCS3]=hist(vv0003,RCS);
CDFN3=(cumsum(N3)/sizedata3(1,1))*100;


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
x1 = RCS1;
y1 = CDFN1;

x2 = RCS2;
y2 = CDFN2;

x3 = RCS3;
y3 = CDFN3;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
subplot(2,1,1)
bar1=bar(RCS1,N1,'b');
set(bar1,'BarWidth',0.6);
hold on;
bar2=bar(RCS2,N2,'m');
set(bar2,'BarWidth',0.4);
hold on;
bar3=bar(RCS3,N3,'g');
set(bar3,'BarWidth',0.2);
hold on;
ax1 = gca;

xlabel('RCS(dBsm)');
ylabel('Quantity');
legend('0<\theta<180 deg','\theta<90 deg','\theta>90 deg');
text(dxmin1+(0.3*dxspan1),dymax1-(0.25*dyspan1),txt3)
grid on;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
subplot(2,1,2)
hl1 = line(x1,y1,'Color','b','linewidth',2);
hold on;       
hl2 = line(x2,y2,'Color','m','linewidth',2);
hold on;
hl3 = line(x3,y3,'Color','g','linewidth',2);
hold on;
 
legend('0<\theta<180 deg','\theta<90 deg','\theta>90 deg');
xlabel('RCS(dBsm)'); 
ylabel('CDF(%)');

grid on;
setxgrid(dxmin2,dxstep2,dxmax2);
setygrid(dymin2,dystep2,dymax2);
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%





