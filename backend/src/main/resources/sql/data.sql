-- 使用数据库
use plutus;

insert into user_group(
    id,
    group_name,
    create_time,
    update_time)
values (1,
        '沌沌和彬彬',
        now(),
        now());

insert into user(id,
                 group_id,
                 username,
                 password,
                 nickname,
                 email,
                 telephone,
                 avatar_url,
                 create_time,
                 update_time)
values (1,
        1,
        'admin',
       'admin',
        'Club4',
        'sht980721@163.com',
        '18936758031',
        'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png',
        now(),
        now());

insert into user(id,
                 group_id,
                 username,
                 password,
                 nickname,
                 email,
                 telephone,
                 avatar_url,
                 create_time,
                 update_time)
values (2,
        1,
        'Alyssayaa',
        '1998Sherry',
        'Alyssayaa',
        'alyssayaasun@163.com',
        '17712820499',
        'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png',
        now(),
        now());