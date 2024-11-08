CREATE DATABASE appwebnominas;

USE appwebnominas;

-- Estructura tablas Empleado y Nomina.

CREATE TABLE Empleado (
    nombre VARCHAR(20) NOT NULL,
    DNI VARCHAR(9) PRIMARY KEY,
    sexo CHAR(1) NOT NULL,
    categoria INT DEFAULT 1,
    anyos INT DEFAULT 0, 
    CONSTRAINT categoria_chk CHECK ((categoria >= 1) AND (categoria <= 10)),
    CONSTRAINT anyos_chk CHECK ((anyos >= 0))
);

CREATE TABLE Nomina (
    empleado_dni VARCHAR(9),
    sueldoCalculado DECIMAL(10,2),
    estado_nomina VARCHAR(20),
    FOREIGN KEY (empleado_dni) REFERENCES Empleado(DNI)
);

-- Inserción de los empleados y sus nóminas.

INSERT INTO Empleado (nombre, DNI, sexo, categoria, anyos) VALUES 
('Carlos', '12345678A', 'M', 5, 3),
('Ana', '87654321B', 'F', 4, 5),
('Pedro', '11223344C', 'M', 7, 10),
('Laura', '44332211D', 'F', 3, 2),
('Luis', '99887766E', 'M', 2, 1),
('Carlos', '22334455F', 'M', 5, 3),
('Sofía', '66778899G', 'F', 8, 7),
('Elena', '55667788H', 'F', 1, 0),
('Pedro', '33445566I', 'M', 7, 10),
('Lucía', '77889900J', 'F', 10, 6);

INSERT INTO Nomina (empleado_dni, sueldoCalculado, estado_nomina) VALUES 
('12345678A', 32000.00, 'Normal'),
('87654321B', 28000.00, 'Normal'),
('11223344C', 45000.00, 'Enfermedad'),
('44332211D', 26000.00, 'Suspendido'),
('99887766E', 24000.00, 'Normal'),
('22334455F', 32000.00, 'Normal'),
('66778899G', 40000.00, 'Enfermedad'),
('55667788H', 22000.00, 'Normal'),
('33445566I', 45000.00, 'Suspendido'),
('77889900J', 50000.00, 'Normal');
