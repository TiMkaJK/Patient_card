ALTER TABLE user ADD COLUMN enabled BIT(1) NOT NULL DEFAULT 0 AFTER id;
