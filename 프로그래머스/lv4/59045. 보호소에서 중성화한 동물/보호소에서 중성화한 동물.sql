-- https://school.programmers.co.kr/learn/courses/30/lessons/59045
-- 보호소에 들어올 당시에는 중성화1되지 않았지만, 보호소를 나갈 당시에는 중성화된 동물의 아이디와 생물 종, 이름을 조회하는 아이디 순으로 조회하는 SQL 문을 작성
SELECT ANIMAL_OUTS.ANIMAL_ID, ANIMAL_OUTS.ANIMAL_TYPE, ANIMAL_OUTS.NAME FROM ANIMAL_OUTS
    INNER JOIN (SELECT ANIMAL_ID FROM ANIMAL_INS
                WHERE SEX_UPON_INTAKE LIKE 'Intact%') AS NONO
    ON ANIMAL_OUTS.ANIMAL_ID = NONO.ANIMAL_ID
WHERE SEX_UPON_OUTCOME NOT LIKE 'Intact%'
ORDER BY ANIMAL_ID
;