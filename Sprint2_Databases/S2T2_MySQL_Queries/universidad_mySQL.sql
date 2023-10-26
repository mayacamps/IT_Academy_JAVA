SELECT apellido1, apellido2, nombre FROM persona WHERE tipo = 'alumno' ORDER BY apellido1;
SELECT apellido1, apellido2, nombre FROM persona WHERE tipo = 'alumno' AND telefono IS NULL;
SELECT apellido1, apellido2, nombre FROM persona WHERE tipo = 'alumno' AND YEAR(fecha_nacimiento) = 1999;
SELECT apellido1, apellido2, nombre FROM persona WHERE tipo = 'profesor' AND telefono IS NULL AND nif LIKE '%K';
SELECT nombre FROM asignatura WHERE cuatrimestre = 1 AND curso = 3 AND id_grado = 7;
SELECT apellido1, apellido2, p.nombre, d.nombre FROM persona AS p INNER JOIN profesor AS prof ON p.id = prof.id_profesor INNER JOIN departamento AS d ON prof.id_departamento = d.id WHERE p.tipo = 'profesor' ORDER BY apellido1;
SELECT asig.nombre, c.anyo_inicio, c.anyo_fin FROM asignatura AS asig INNER JOIN alumno_se_matricula_asignatura AS asma ON asig.id = asma.id_asignatura INNER JOIN curso_escolar AS c ON asma.id_curso_escolar = c.id INNER JOIN persona as p ON p.id = asma.id_alumno WHERE p.nif = '26902806M';
SELECT DISTINCT d.nombre FROM departamento AS d INNER JOIN profesor AS prof ON d.id = prof.id_departamento INNER JOIN asignatura AS asig ON prof.id_profesor = asig.id_profesor INNER JOIN grado ON asig.id_grado = grado.id WHERE grado.nombre = 'Grado en Ingeniería Informática (Plan 2015)';
SELECT DISTINCT apellido1, apellido2, nombre FROM persona INNER JOIN alumno_se_matricula_asignatura AS asma ON persona.id = asma.id_alumno INNER JOIN curso_escolar AS c ON asma.id_curso_escolar = c.id WHERE tipo = 'alumno' AND anyo_inicio = 2018;