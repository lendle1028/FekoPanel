clear all


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
X=[30,40,50,60,70,80,90];
CAY_20=[5.68,5.36,4.73,4.02,3.44,2.93,2.53];
CBY_20=[11.83,10.31,8.62,6.85,5.72,4.88,4.21];
CCY_20=[18.34,15.67,12.87,10.51,8.72,7.42,6.41];
CAY_10=[40.13,36.82,33.73,28.97,24.77,21.46,18.65];
CBY_10=[52.79,48.30,43.66,36.74,31.07,26.79,23.25];
CCY_10=[64.76,61.17,56.88,48.23,41.07,35.36,30.73];
CAY_0=[86.41,84.66,84.31,81.30,75.75,68.72,60.51];
CBY_0=[88.08,86.47,85.77,82.85,77.19,70.11,61.66];
CCY_0=[91.43,91.46,91.11,89.03,84.45,78.87,70.31];



%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

dxmax=90;   %180,30            %assign  X / Y SCALE for D_plot
dxmin=30;
dxstep=10;   %10,3
dxspan=dxmax-dxmin;



%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
hh=figure(1);
dymax=20;
dymin=0;
dystep=2; 
dyspan=dymax-dymin;
titlestr='RCS CDF統計(CDF：RCS -20dBsm (0.01m^2)；俯仰角：17~\theta 度；方位角：-90~90 度)';
xlbl='\theta (度)';                     %assign  LABEL
ylbl='CDF (%)';

plot(X,CAY_20,'b',X,CBY_20,'m',X,CCY_20,'r','linewidth',2);
legend('原型機(未研改)','EOIR匿蹤處理','EOIR匿蹤處理+前小翼與後水平翼使用非金屬材質');

title(titlestr);
title(titlestr,'fontsize',12,'fontweight','b');
xlabel(xlbl,'fontsize',16,'fontweight','b');
ylabel(ylbl,'fontsize',16,'fontweight','b');

grid on;
setxgrid(dxmin,dxstep,dxmax);
setygrid(dymin,dystep,dymax);
xlabel(xlbl);
ylabel(ylbl);
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
hh=figure(2);
dymax=70;
dymin=10;
dystep=10; 
dyspan=dymax-dymin;
titlestr='RCS CDF統計(CDF：RCS -10dBsm (0.1m^2)；俯仰角：17~\theta 度；方位角：-90~90 度)';
xlbl='\theta (度)';                     %assign  LABEL
ylbl='CDF (%)';

plot(X,CAY_10,'b',X,CBY_10,'m',X,CCY_10,'r','linewidth',2);
legend('原型機(未研改)','EOIR匿蹤處理','EOIR匿蹤處理+前小翼與後水平翼使用非金屬材質');

title(titlestr);
title(titlestr,'fontsize',12,'fontweight','b');
xlabel(xlbl,'fontsize',16,'fontweight','b');
ylabel(ylbl,'fontsize',16,'fontweight','b');

grid on;
setxgrid(dxmin,dxstep,dxmax);
setygrid(dymin,dystep,dymax);
xlabel(xlbl);
ylabel(ylbl);
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
hh=figure(3);
dymax=100;
dymin=60;
dystep=10; 
dyspan=dymax-dymin;
titlestr='RCS CDF統計(CDF：RCS 0dBsm (1m^2)；俯仰角：17~\theta 度；方位角：-90~90 度)';
xlbl='\theta (度)';                     %assign  LABEL
ylbl='CDF (%)';

plot(X,CAY_0,'b',X,CBY_0,'m',X,CCY_0,'r','linewidth',2);
legend('原型機(未研改)','EOIR匿蹤處理','EOIR匿蹤處理+前小翼與後水平翼使用非金屬材質');

title(titlestr);
title(titlestr,'fontsize',12,'fontweight','b');
xlabel(xlbl,'fontsize',16,'fontweight','b');
ylabel(ylbl,'fontsize',16,'fontweight','b');

grid on;
setxgrid(dxmin,dxstep,dxmax);
setygrid(dymin,dystep,dymax);
xlabel(xlbl);
ylabel(ylbl);
