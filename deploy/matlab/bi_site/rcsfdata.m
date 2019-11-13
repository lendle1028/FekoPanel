function [data] = rcsfdata(filename,Header_l,Column_n)
%RCSDATA        input RCS data from file,selete by wildcard.
%       RCSDATA(pathname,Header_l,Column_n) take out RCS data from any file seleted.
%       pathname  : path name of rcs data file.
%       Header_l   : length of headerin in rcs dtata file.
%       Column_n : number of the column of rcs data matrix.
%
%       Modified by Yang, rong-tzong    Dec 2 1997
%
%       Copyright (c) 1984-93 by The MathWorks, Inc.

%eval(['cd ' pathname]);
%filename=uigetfile('*.*', 'Data File Selection'); % Select one file with wildcard
if(filename==0) cd d:\ravis\mfile; return; end;
fid=fopen(filename, 'rb');    if(fid==0) cd d:\ravis\mfile; return; end;
for i=1:Header_l; lines=fgetl(fid); end;
arr=fscanf(fid, '%f', [Column_n,inf]);
fclose(fid);
data=arr';
clear arr;
%cd d:\ravis\mfile;
