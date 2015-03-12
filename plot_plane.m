P1 = [0, 0, 0.4251645916515102]
P2 = [0, 0.5398894393122825, 0]
P3 = [0.50977924440953232, 0, 0]

normal = cross(P1-P2, P1-P3)

syms x y z
P = [x,y,z]
planefunction = dot(normal, P-P1)

dot(P-P1, normal)

realdot = @(u, v) u*transpose(v);

realdot(P-P1,normal)

P4 = [1,2,-1];
P5 = [3,3,3];

zplane = solve(planefunction, z)

px = [0,0,0,0,1,1,1,1];
py = [0,0,1,1,0,0,1,1];
pz = [0,1,0,1,0,1,0,1];
ezmesh(zplane, [0, 1, 0, 1]), hold on
plot3(px,py,pz,'ro'); hold on
axis([0, 1, 0, 1, 0, 1]), title ''

%[X,Y]=meshgrid(0:0.01:1);
%Z=X.^2+Y.^2;
%plot3(0,0,0,'marker','o');
%plot3(0,0,1,'marker','o');
%plot3(0,1,0,'marker','o');
%plot3(0,1,1,'marker','o');
%plot3(1,0,0,'marker','o');
%plot3(1,0,1,'marker','o');
%plot3(1,1,0,'marker','o');
%plot3(1,1,1,'marker','o');
%mesh(X,Y,Z)
%zlim([0 1])

%plot_line(X,Y,Z);

%fill3(X,Y,Z,'b') 
%grid on 
