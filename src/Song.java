public class Song {
    private Artist artist;
    private String name;

    public Song(Artist _artist, String _name) {
      artist = _artist;
      name = _name;
    }

    public String getName() {
      return name;
    }

    public Artist getArtist() {
      return artist;
    }

    public boolean equals(Song other) {
      return artist.equals(other.artist) && name.equals(other.name);
    }

    public String toString() {
      String result = "[Name: " + name + ", Artist: " + artist + "]";
      return result;
    }
}
