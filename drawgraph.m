alphas = [0,0.05,0.1,0.15,0.2,0.25,0.3,0.35,0.4,0.45,0.5,0.55,0.6,0.65,0.7,0.75,0.8,0.85,0.9,0.95,1.0,];
values = [Inf(1),2519.8,1273.2,854.2,628.4,508.6,430.4,372.6,325.2,287.6,261.4,235.0,215.6,205.8,190.0,177.4,165.0,155.6,147.8,140.4,135.0,];
plot(alphas, values);
title('Vztah rychlosti ucenia a poctu iteracii (AND)');
xlabel('rychlost ucenia');
ylabel('rychlost konvergencie (# iteracii)');
