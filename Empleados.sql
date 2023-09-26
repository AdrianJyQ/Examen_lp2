drop database EmpleadosExamen;

create database EmpleadosExamen;

use EmpleadosExamen;

CREATE TABLE Empleados (
    IdEmpleado INT AUTO_INCREMENT PRIMARY KEY,
    Apellidos VARCHAR(20) NOT NULL,
    Nombres VARCHAR(20) NOT NULL,
    Edad INT CHECK (edad >= 18),
    Sexo CHAR(1) CHECK (sexo IN ('M', 'F')),
    Salario DECIMAL(8,2) CHECK (salario BETWEEN 1500 AND 2500)
);


INSERT INTO Empleados (Apellidos, Nombres, Edad, Sexo, Salario)
VALUES
    ('TORRES', 'JOSE', 22, 'M', 1500),
    ('GARCIA', 'MARIA', 21, 'F', 1750),
    ('FLORES', 'JUAN', 22, 'M', 1850),
    ('CASAS', 'ANA', 23, 'F', 2000),
    ('RODRIGUEZ', 'CARLOS', 25, 'M', 2200);

select * from Empleados