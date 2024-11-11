-- Tabla usuario
CREATE TABLE usuario (
    id_usuario SERIAL PRIMARY KEY,
	id_login VARCHAR(30) NOT NULL UNIQUE,
    contrasena VARCHAR(60) NOT NULL,  -- Hash de la contraseña
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL
);

-- Tabla aula_general (debe ir antes de las referencias)
CREATE TABLE aula_general (
    id_aula SERIAL PRIMARY KEY,
    tipo VARCHAR(15) NOT NULL,
    ubicacion VARCHAR(30) NOT NULL,
    estado BOOLEAN NOT NULL,
    capacidad INTEGER NOT NULL,
    piso INTEGER NOT NULL,
    tipo_pizarron VARCHAR(15),
    ventiladores BOOLEAN,
    aire_acondicionado BOOLEAN,
    habilitado BOOLEAN NOT NULL,
    CONSTRAINT uq_ubicacion_piso UNIQUE(ubicacion, piso) 
);

-- Tabla bedel
CREATE TABLE bedel (
    id_usuario INT PRIMARY KEY REFERENCES usuario(id_usuario),
    turno VARCHAR(10) NOT NULL,
    habilitado BOOLEAN NOT NULL
);

-- Tabla administrador
CREATE TABLE administrador (
    id_usuario INT PRIMARY KEY REFERENCES usuario(id_usuario)
    );

-- Tabla reserva
CREATE TABLE reserva (
    id_reserva SERIAL PRIMARY KEY,
    id_docente INT NOT NULL,
    nombre_docente VARCHAR(50) NOT NULL,
    apellido_docente VARCHAR(50) NOT NULL,
    email_docente VARCHAR(50) NOT NULL,
    id_catedra INT NOT NULL,
    nombre_catedra VARCHAR(50) NOT NULL,
    fecha_registro TIMESTAMP NOT NULL,
    id_bedel INT REFERENCES bedel(id_usuario)
);

-- Tabla detalle_reserva
CREATE TABLE detalle_reserva (
    id_detalle_reserva SERIAL,
    id_reserva INTEGER REFERENCES reserva(id_reserva),
    horario_inicio TIME NOT NULL,
    fecha DATE NOT NULL,
    cant_modulos INTEGER NOT NULL,
    dia_reserva VARCHAR(10) NOT NULL,
    id_aula INT REFERENCES aula_general(id_aula),
    CONSTRAINT detalle_reserva_pk PRIMARY KEY(id_detalle_reserva),
    CONSTRAINT id_aula_horario_inicio_fecha_uq UNIQUE(id_aula, horario_inicio, fecha)
);

-- Tabla aula_multimedios
CREATE TABLE aula_multimedios (
    id_aula INT PRIMARY KEY REFERENCES aula_general(id_aula),
    televisor BOOLEAN,
    canon BOOLEAN,
    computadora BOOLEAN
);

-- Tabla aula_laboratorio
CREATE TABLE aula_laboratorio (
    id_aula INT PRIMARY KEY REFERENCES aula_general(id_aula),
    cantidad_pc INTEGER
);

-- Tabla reserva_periodica
CREATE TABLE reserva_periodica (
    id_reserva INTEGER  PRIMARY KEY REFERENCES reserva(id_reserva),
    tipo VARCHAR(15) NOT NULL,
    dias_semana JSON NOT NULL  -- Almacenamos días de la semana en formato JSON
);

-- Tabla reserva_esporadica
CREATE TABLE reserva_esporadica (
    id_reserva INTEGER PRIMARY KEY REFERENCES reserva(id_reserva)
);

-- Tabla cuatrimestre
CREATE TABLE cuatrimestre (
    id_cuatrimestre SERIAL PRIMARY KEY,
    fecha_inicio_cuatrimestre DATE NOT NULL,
    fecha_fin_cuatrimestre DATE NOT NULL
);

-- Relación entre cuatrimestre y reserva_periodica
CREATE TABLE periodo_asignado (
    id_cuatrimestre INT NOT NULL REFERENCES cuatrimestre(id_cuatrimestre),
    id_reserva_periodica INT NOT NULL REFERENCES reserva_periodica(id_reserva),
    PRIMARY KEY (id_cuatrimestre, id_reserva_periodica)
);

