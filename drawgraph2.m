x = [0,0,0,0,1,1,1,1];
y = [0,0,1,1,0,0,1,1];
z = [0,1,0,1,0,1,0,1];



interval=0:.01:1;
[X,Y] = meshgrid(interval);
a=2.8456160940803605; b=2.992423524879141; c=3.0273892995886458; d=7.956427158845949;
Z=(d- a * X - b * Y)/c;
surf(X,Y,Z)
shading flat
xlabel('x'); ylabel('y'); zlabel('z')

plot3(x,y,z,'ro', Z)
