alphas = [0,0.2,0.4,0.6,0.8,1.0,1.2,1.4,1.6,1.8,2.0,2.2,2.4,2.6,2.8,3.0,3.2,3.4,3.6,3.8,4.0];
values = [Inf(1),49.4,25.6,17.4,13.6,11.4,10.6,8.6,7.6,7.6,6.4,6.4,6.2,6.2,5.4,5.2,4.8,5.0,5.2,4.6,4.2];
plot(alphas, values);
title('Vztah rychlosti ucenia a poctu iteracii (OR)');
xlabel('rychlost ucenia');
ylabel('rychlost konvergencie (# iteracii)');
