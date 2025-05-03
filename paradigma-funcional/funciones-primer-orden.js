const ventas = [
    { id: 1, monto: 500 },
    { id: 2, monto: 1500 },
    { id: 3, monto: 2000 },
  ];
  
const total = ventas
.filter(v => v.monto > 1000)    // función de primer orden
.map(v => v.monto)              // función de primer orden
.reduce((a, b) => a + b, 0);    // función de primer orden

console.log(total); // 3500