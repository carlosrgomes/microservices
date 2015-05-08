INSERT INTO oauth_client_details
  (client_id,
   client_secret,
   resource_ids,
   scope,
   authorized_grant_types,
   web_server_redirect_uri,
   authorities,
   access_token_validity,
   refresh_token_validity,
   additional_information)
VALUES
  ('visitantesclient',
   'somesecret',
   null,
   'read,write',
   'password,authorization_code,refresh_token,implicit,client_credentials',
   null,
   'ROLE_CLIENT, ROLE_TRUSTED_CLIENT',
   60,
   null,
   null);