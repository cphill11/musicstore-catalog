use music_store_catalog;

insert into album(title, artist_id, release_date, label_id, list_price, index fk_artist_id, index fk_label_id)
    values("Entitled", 123, 1999, 1, 2.99, 1, 1);


insert into artist(name, instagram, twitter)
    values("Bob", "IG@What", "Twitter@IsThisStillAThing?");


insert into label(name, website);
    values("Don't Label Me", "TooMuchSoda@overcaffeinated.com");


insert into track(album_id, title, run_time, index fk_album_id);
    values(1, "Enitled", 2, 1);
