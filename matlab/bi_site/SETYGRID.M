function [out]=setygrid(ymin,ydelta,ymax);
%GRID	Grid lines for 2-D and 3-D plots.
% 	GRID ON adds grid lines to the current axes.
% 	GRID OFF takes them off.
% 	GRID, by itself, toggles the grid state.
%
%	GRID sets the XGrid, YGrid, and ZGrid properties of
%	the current axes.
%
%	See also TITLE, XLABEL, YLABEL, ZLABEL, AXES, PLOT.

%	Copyright (c) 1984-93 by The MathWorks, Inc.

ax = gca;
if nargin ~= 3
        error('Requires 3 input arguments. (min,delta,max)')
else
	set(ax,'YLim', [ymin ymax]);
        yt=ymin:ydelta:ymax; 
	set(ax,'YTick', yt);
end
end