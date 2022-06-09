USE helpdesk;

############# USERS #############

	######### Access Status #########

	INSERT IGNORE INTO user_access_status (name, active, create_date_time, update_date_time) VALUES ('Active', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
	INSERT IGNORE INTO user_access_status (name, active, create_date_time, update_date_time) VALUES ('Suspended', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
	INSERT IGNORE INTO user_access_status (name, active, create_date_time, update_date_time) VALUES ('Disabled', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
	SET @activeAccessStatus = (SELECT id FROM user_access_status WHERE name = 'Active');

	######### Access #########

	INSERT IGNORE INTO user_access (user_name, password, status_id, create_date_time, update_date_time) VALUES ('test', 'dinofaurio', @activeAccessStatus, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
	SET @testAccessId = (SELECT id FROM user_access WHERE user_name = 'test');

	######### User Status #########

	INSERT IGNORE INTO user_status (name, active, create_date_time, update_date_time) VALUES ('Active', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
	SET @activeUserStatus = (SELECT id FROM user_status WHERE name = 'Active');
	INSERT IGNORE INTO user_status (name, active, create_date_time, update_date_time) VALUES ('Leave', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
	INSERT IGNORE INTO user_status (name, active, create_date_time, update_date_time) VALUES ('Terminated', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

	######### User #########

	INSERT IGNORE INTO USER (first_name, last_name, email, phone, image, access_id, user_status_id, create_date_time, update_date_time) 
		VALUES ('Test', 'Test', 'santimaldini07@gmail.com', 1234567890, 'dinofaurio.jpg', @testAccessId, @activeUserStatus, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
	SET @testUserId = (SELECT id FROM user WHERE first_name = 'Test');
		

############# ROLES #############

	######### Role #########

	INSERT IGNORE INTO `role` (name, description, active, create_date_time, update_date_time) VALUES ('Admin', 'Allows admin accesss', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
	SET @adminRoleId = (SELECT id FROM `role` WHERE name = 'Admin');
	INSERT IGNORE INTO `role` (name, description, active, create_date_time, update_date_time) VALUES ('Viewer', 'Allows Viewer accesss', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
	INSERT IGNORE INTO `role` (name, description, active, create_date_time, update_date_time) VALUES ('Technician', 'Allows Technician accesss', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

	######### Role Access #########

	INSERT IGNORE INTO access_role (user_access_id, role_id, create_date_time) VALUES (@testAccessId, @adminRoleId, CURRENT_TIMESTAMP);
	
	####### Role Admin Access #######
	
	INSERT IGNORE INTO role_admin_access (name, description, active, create_date_time, update_date_time) VALUES ('Owner', 'Is owner of the role', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
	SET @ownerRoleId = (SELECT id FROM role_admin_access WHERE name = 'Owner');
	INSERT IGNORE INTO role_admin_access (name, description, active, create_date_time, update_date_time) VALUES ('Approver', 'Can approve membership of the role', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

	######### Role Admin #########

	INSERT IGNORE INTO role_admin (user_access_id, role_id, access_id, create_date_time) VALUES (@testAccessId, @adminRoleId, @ownerRoleId, CURRENT_TIMESTAMP);
	

############# GROUPS #############

	######### Group #########

	INSERT IGNORE INTO user_group (name, description, active, create_date_time, update_date_time) VALUES ('Help Desk L1', 'General Help Desk group', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

	SET @groupId = (SELECT id FROM user_group WHERE name = 'Help Desk L1');

	######### Group Access #########

	INSERT IGNORE INTO access_group (user_access_id, group_id, create_date_time) VALUES (@testAccessId, @groupId, CURRENT_TIMESTAMP);
	
	######### Group Admin Access #########

	INSERT IGNORE INTO group_admin_access (name, description, active, create_date_time, update_date_time) VALUES ('Owner', 'Is owner of the role', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
	INSERT IGNORE INTO group_admin_access (name, description, active, create_date_time, update_date_time) VALUES ('Approver', 'Is owner of the role', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
	
	SET @ownerGroupId = (SELECT id FROM group_admin_access WHERE name = 'Owner');
	
	######### Group Admin #########

	INSERT IGNORE INTO group_admin (user_access_id, group_id, access_id, create_date_time) VALUES (@testAccessId, @groupId, @ownerGroupId, CURRENT_TIMESTAMP);


############# TICKETS #############

	######### Category #########

	INSERT IGNORE INTO ticket_category (name, parent, active, create_date_time, update_date_time) VALUES ('Hardware', NULL, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
	INSERT IGNORE INTO ticket_category (name, parent, active, create_date_time, update_date_time) VALUES ('Software', NULL, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

	SET @hardwareId = (SELECT id FROM ticket_category WHERE name = 'Hardware');

	INSERT IGNORE INTO ticket_category (name, parent, active, create_date_time, update_date_time) VALUES ('Monitor', @hardwareId, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

	SET @monitorId = (SELECT id FROM ticket_category WHERE name = 'Monitor');

	INSERT IGNORE INTO ticket_category (name, parent, active, create_date_time, update_date_time) VALUES ("Doesn't turn on", @hardwareId, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

	SET @categoryId = (SELECT id FROM ticket_category WHERE name = "Doesn't turn on" AND parent = @hardwareId);

	######### Priority #########

	INSERT IGNORE INTO ticket_priority (name, active, create_date_time, update_date_time) VALUES ('Low', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
	INSERT IGNORE INTO ticket_priority (name, active, create_date_time, update_date_time) VALUES ('Medium', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
	INSERT IGNORE INTO ticket_priority (name, active, create_date_time, update_date_time) VALUES ('High', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
	INSERT IGNORE INTO ticket_priority (name, active, create_date_time, update_date_time) VALUES ('Critical', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

	SET @priorityId = (SELECT id FROM ticket_priority WHERE name = "Low");

	######### Status #########
	
	INSERT IGNORE INTO ticket_status (name, active, create_date_time, update_date_time) VALUES ('Draft', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
	INSERT IGNORE INTO ticket_status (name, active, create_date_time, update_date_time) VALUES ('In progress', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
	INSERT IGNORE INTO ticket_status (name, active, create_date_time, update_date_time) VALUES ('Awaiting customer', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
	INSERT IGNORE INTO ticket_status (name, active, create_date_time, update_date_time) VALUES ('Resolved', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
	INSERT IGNORE INTO ticket_status (name, active, create_date_time, update_date_time) VALUES ('Cancelled', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

	SET @statusId = (SELECT id FROM ticket_status WHERE name = "In progress");

	######### Configuration Item #########

	INSERT IGNORE INTO configuration_item (name, description, group_id, active, create_date_time, update_date_time) VALUES ('Desk', 'Products included in desk', @groupId, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

	SET @configurationItemId = (SELECT id FROM configuration_item WHERE name = 'Desk');

	######### Ticket #########

	INSERT IGNORE INTO ticket (subject, description, category_id, priority_id, group_id, user_id, requester_id, technician_id, configuration_item_id, status_id, create_date_time, update_date_time)
		VALUES ("The monitor doesn't turn on!", "The monitor doesn't turn on!", @categoryId, @priorityId, @groupId, @testUserId, @testUserId, @testUserId, @configurationItemId, @statusId, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

	SET @ticketId = (SELECT id FROM ticket LIMIT 1);

	######### Comment #########

	INSERT IGNORE INTO ticket_comment (comment, user_access_id, ticket_id, create_date_time) VALUES ('Please help!!', @testAccessId, @ticketId, CURRENT_TIMESTAMP);











