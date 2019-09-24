function [hpol] = rcspgrid(rmax,step,rmin)
%RCSPGRID       Plot Polar coordinate grid for Radar Cross Section.
%       RCSPGRID (RMAX,STEP,RMIN) makes a plot of polar coordinates
%       grid for Radar Cross Section data plot in polar coordinates.
%       RMAX,STEP,RMIN use to specify the scale you need.
%
%       Modified by Y.R.J.   11/18/1997
%
%       Copyright (c) 1984-93 by The MathWorks, Inc.

% make a radial grid
            %tc = 'w';           % white for black background
            tc = 'k';           % black for white background
            span=rmax-rmin;
            rticks=span/step;
            rinc=span/rticks;

% define a circle
        th = 0:pi/50:2*pi;
        xunit = cos(th);
        yunit = sin(th);

        for i=1:rticks-1
%               plot(xunit*i*rinc,yunit*i*rinc,'-','color',tc,'linewidth',1);
                plot(xunit*i*rinc,yunit*i*rinc,'-','color',tc);
                text(0,i*rinc,['  ' num2str(i*step+rmin)],'verticalalignment','bottom');
        end
%               plot(xunit*rticks*rinc,yunit*rticks*rinc,'-','color',tc,'linewidth',1);
                plot(xunit*rticks*rinc,yunit*rticks*rinc,'-','color',tc);
                text(0,rticks*rinc,['  ' num2str(rticks*step+rmin) 'dbsm'],'verticalalignment','bottom');

% plot spokes
        th = (1:6)*2*pi/12;
        cst = cos(th); snt = sin(th);
        cs = [-cst; cst];
        sn = [-snt; snt];
        plot(span*cs,span*sn,':','color',tc,'linewidth',1);

% annotate spokes in degrees
        rt = 1.1*span;
        for i = 1:max(size(th))
                text(rt*cst(i),rt*snt(i),int2str(i*30),'horizontalalignment','center');
                if i == max(size(th))
                        loc = int2str(0);
                else
                        loc = int2str(180+i*30);
                end
                text(-rt*cst(i),-rt*snt(i),loc,'horizontalalignment','center');
        end

