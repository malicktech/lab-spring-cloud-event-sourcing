CREATE DATABASE IF NOT EXISTS akeneo_pim CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER 'akeneo'@'%' IDENTIFIED BY 'akeneo';
GRANT ALL ON akeneo_pim.* TO 'akeneo'@'%' IDENTIFIED BY 'akeneo';
GRANT ALL ON akeneo_pim.* TO 'akeneo'@'localhost' IDENTIFIED BY 'akeneo';
