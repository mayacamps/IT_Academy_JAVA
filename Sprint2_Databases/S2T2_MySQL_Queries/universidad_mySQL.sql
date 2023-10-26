/*1*/SELECT apellido1, apellido2, nombre FROM persona WHERE tipo = 'alumno' ORDER BY apellido1, apellido2, nombre;
/*2*/SELECT apellido1, apellido2, nombre FROM persona WHERE tipo = 'alumno' AND telefono IS NULL;
/*3*/SELECT apellido1, apellido2, nombre FROM persona WHERE tipo = 'alumno' AND YEAR(fecha_nacimiento) = 1999;
/*4*/SELECT apellido1, apellido2, nombre FROM persona WHERE tipo = 'profesor' AND telefono IS NULL AND nif LIKE '%K';
/*5*/SELECT nombre AS asignatura FROM asignatura WHERE cuatrimestre = 1 AND curso = 3 AND id_grado = 7;
/*6*/SELECT apellido1, apellido2, p.nombre, d.nombre AS departamento FROM persona AS p INNER JOIN profesor AS prof ON p.id = prof.id_profesor INNER JOIN departamento AS d ON prof.id_departamento = d.id WHERE p.tipo = 'profesor' ORDER BY apellido1, apellido2, p.nombre;
/*7*/SELECT asig.nombre AS asignatura, c.anyo_inicio, c.anyo_fin FROM asignatura AS asig INNER JOIN alumno_se_matricula_asignatura AS asma ON asig.id = asma.id_asignatura INNER JOIN curso_escolar AS c ON asma.id_curso_escolar = c.id INNER JOIN persona as p ON p.id = asma.id_alumno WHERE p.nif = '26902806M';
/*8*/SELECT DISTINCT d.nombre AS departamento FROM departamento AS d INNER JOIN profesor AS prof ON d.id = prof.id_departamento INNER JOIN asignatura AS asig ON prof.id_profesor = asig.id_profesor INNER JOIN grado ON asig.id_grado = grado.id WHERE grado.nombre = 'Grado en Ingeniería Informática (Plan 2015)';
/*9*/SELECT DISTINCT apellido1, apellido2, nombre FROM persona INNER JOIN alumno_se_matricula_asignatura AS asma ON persona.id = asma.id_alumno INNER JOIN curso_escolar AS c ON asma.id_curso_escolar = c.id WHERE tipo = 'alumno' AND anyo_inicio = 2018;

-- LEFT JOIN AND RIGHT JOIN
/*1*/SELECT d.nombre AS departamento, apellido1, apellido2, p.nombre FROM persona AS p INNER JOIN profesor AS prof ON p.id = prof.id_profesor LEFT JOIN departamento AS d ON prof.id_departamento = d.id ORDER BY d.nombre, apellido1, apellido2, p.nombre;
/*2*/SELECT apellido1, apellido2, p.nombre FROM persona AS p INNER JOIN profesor AS prof ON p.id = prof.id_profesor LEFT JOIN departamento AS d ON prof.id_departamento = d.id WHERE d.id IS NULL ORDER BY d.nombre;
/*3*/SELECT d.nombre AS departamento FROM departamento AS d LEFT JOIN profesor AS prof ON d.id = prof.id_departamento WHERE prof.id_departamento IS NULL ORDER BY d.nombre;
/*4*/SELECT apellido1, apellido2, p.nombre FROM persona AS p INNER JOIN profesor AS prof ON p.id = prof.id_profesor LEFT JOIN asignatura AS asig ON prof.id_profesor = asig.id_profesor WHERE asig.id_profesor IS NULL ORDER BY prof.id_profesor;
/*5*/SELECT asig.nombre FROM persona AS p INNER JOIN profesor AS prof ON p.id = prof.id_profesor RIGHT JOIN asignatura AS asig ON prof.id_profesor = asig.id_profesor WHERE prof.id_profesor IS NULL;

-- SUMMARY
/*1*/SELECT COUNT(p.id) AS cantidad_alumnos FROM persona AS p WHERE tipo = 'alumno';
/*2*/SELECT COUNT(p.id) AS cantidad_alumnos_nacidos_1999 FROM persona AS p WHERE tipo = 'alumno' AND YEAR(fecha_nacimiento) = 1999;
/*3*/SELECT d.nombre AS departamento, COUNT(prof.id_profesor) AS cantidad_profesores FROM departamento AS d INNER JOIN profesor AS prof ON d.id = prof.id_departamento GROUP BY d.nombre ORDER BY COUNT(prof.id_profesor) DESC;
/*4*/SELECT d.nombre AS departamento, COUNT(prof.id_profesor) AS cantidad_profesores FROM departamento AS d LEFT JOIN profesor AS prof ON d.id = prof.id_departamento GROUP BY d.nombre ORDER BY COUNT(prof.id_profesor), d.nombre;
/*5*/SELECT g.nombre AS grado, COUNT(asig.nombre) AS numero_asignaturas FROM grado AS g LEFT JOIN asignatura AS asig ON g.id = asig.id_grado GROUP BY g.nombre ORDER BY numero_asignaturas DESC;
/*6*/SELECT g.nombre AS grado, COUNT(asig.nombre) AS numero_asignaturas FROM grado AS g LEFT JOIN asignatura AS asig ON g.id = asig.id_grado GROUP BY g.nombre HAVING numero_asignaturas > 40;
