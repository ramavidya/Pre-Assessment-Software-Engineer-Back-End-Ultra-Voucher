create database ultra_voucher;
use ultra_voucher;

create table m_user
(
	id varchar(100) not null,
    name varchar(100),
    parent_id varchar(100)
)engine InnoDB;

INSERT INTO m_user (id, name, parent_id)
VALUES 
    ('1', 'Zaki', '2');
INSERT INTO m_user (id, name)
VALUES 
    ('2', 'Ilham');
INSERT INTO m_user (id, name, parent_id)
VALUES 
    ('3', 'Irwan', '2'),
    ('4', 'Arka', '3');
    
select * from m_user;
select 	a1.id, 
		a1.name, 
		a2.name AS parent_name
from
	m_user a1
left join
    m_user a2 ON a1.parent_id = a2.id;
