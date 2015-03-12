alphas = [0,0.05,0.1,0.15,0.2,0.25,0.3,0.35,0.4,0.45,0.5,0.55,0.6,0.65,0.7,0.75,0.8,0.85,0.9,0.95,1.0,];
values = [Inf(1),25.34,11.97,9.51,6.62,6.29,5.42,5.61,4.75,4.53,4.78,4.41,4.48,4.16,4.22,3.92,3.98,4.13,4.27,4.14,4.2,];
plot(alphas, values);
title('Vztah rychlosti ucenia a poctu iteracii (AND)');
xlabel('rychlost ucenia');
ylabel('rychlost konvergencie (# iteracii)');
