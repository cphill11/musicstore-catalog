use music_store_catalog;

insert into artist(name, instagram, twitter)
    values("Bob", "IG@What", "Twitter@IsThisStillAThing?");


insert into label(name, website)
    values("Don't Label Me", "TooMuchSoda@overcaffeinated.com");

insert into album(title, artist_id, release_date, label_id, list_price)
    values("Entitled", 1, CURRENT_DATE(), 1, 2.99);

insert into track(album_id, title, run_time)
    values(2, "Enitled", 1);