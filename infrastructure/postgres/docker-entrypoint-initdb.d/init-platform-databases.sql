CREATE USER platform_auth_user WITH PASSWORD 'platform_auth_password';
CREATE DATABASE platform_auth_db OWNER platform_auth_user;

CREATE USER platform_user_user WITH PASSWORD 'platform_user_password';
CREATE DATABASE platform_user_db OWNER platform_user_user;

CREATE USER platform_customer_user WITH PASSWORD 'platform_customer_password';
CREATE DATABASE platform_customer_db OWNER platform_customer_user;

CREATE USER platform_account_user WITH PASSWORD 'platform_account_password';
CREATE DATABASE platform_account_db OWNER platform_account_user;

CREATE USER platform_transaction_user WITH PASSWORD 'platform_transaction_password';
CREATE DATABASE platform_transaction_db OWNER platform_transaction_user;

CREATE USER platform_payment_user WITH PASSWORD 'platform_payment_password';
CREATE DATABASE platform_payment_db OWNER platform_payment_user;

CREATE USER platform_order_user WITH PASSWORD 'platform_order_password';
CREATE DATABASE platform_order_db OWNER platform_order_user;

CREATE USER platform_notification_user WITH PASSWORD 'platform_notification_password';
CREATE DATABASE platform_notification_db OWNER platform_notification_user;

CREATE USER platform_document_user WITH PASSWORD 'platform_document_password';
CREATE DATABASE platform_document_db OWNER platform_document_user;

CREATE USER platform_audit_user WITH PASSWORD 'platform_audit_password';
CREATE DATABASE platform_audit_db OWNER platform_audit_user;

CREATE USER platform_reporting_user WITH PASSWORD 'platform_reporting_password';
CREATE DATABASE platform_reporting_db OWNER platform_reporting_user;

ALTER USER platform_auth_user WITH SUPERUSER;
