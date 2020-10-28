\connect math

SET SESSION AUTHORIZATION math;

-- topic
INSERT INTO math.topic (name, "desc", image) VALUES ('trygonometria', 'Jakis opis', 'http://192.168.1.69:8125/images/topic/trygonometry.png');
INSERT INTO math.topic (name, "desc", image) VALUES ('geometria', 'Jakis opis', 'http://192.168.1.69:8125/images/topic/geometry.png');
INSERT INTO math.topic (name, "desc", image) VALUES ('ułamki', 'Jakis opis', 'http://192.168.1.69:8125/images/topic/fractions.png');
INSERT INTO math.topic (name, "desc", image) VALUES ('funkcje', 'Jakis opis', 'http://192.168.1.69:8125/images/topic/functions.png');

-- exercises
INSERT INTO math.exercise (question, correct_answer, other_answers, topic_name, solution)
    VALUES ('Jakieś pytanie', 'odpowiedz 1', '{ "data":[{"answer":"odpowiedz 1, z przecinkiem"},{"answer":"odpowiedz 2"}]}', 'trygonometria', NULL);