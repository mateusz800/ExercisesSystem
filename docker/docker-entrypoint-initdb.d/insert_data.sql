\connect math

SET SESSION AUTHORIZATION math;

-- course
INSERT INTO math.course (name, "desc", image) VALUES ('trygonometria', 'Jakis opis', 'http://192.168.1.69:8125/images/course/trygonometry.png');
INSERT INTO math.course (name, "desc", image) VALUES ('geometria', 'Jakis opis', 'http://192.168.1.69:8125/images/course/geometry.png');
INSERT INTO math.course (name, "desc", image) VALUES ('ułamki', 'Jakis opis', 'http://192.168.1.69:8125/images/course/fractions.png');
INSERT INTO math.course (name, "desc", image) VALUES ('funkcje', 'Jakis opis', 'http://192.168.1.69:8125/images/course/functions.png');

-- exercises
INSERT INTO math.exercise (question, correct_answers, incorrectgit _answers, topic_name, solution)
    VALUES ('Jakieś pytanie', '{ "data":[{"answer":"poprawna odpowiedź"}]}', '{ "data":[{"answer":"odpowiedz 1, z przecinkiem"},{"answer":"odpowiedz 2"}]}', 'trygonometria', NULL);