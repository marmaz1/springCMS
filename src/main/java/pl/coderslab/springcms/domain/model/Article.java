package pl.coderslab.springcms.domain.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    @NotNull
    @Size(max = 200)
    private String title;

    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany
    @JoinColumn(name = "categories_id")
    @Size(min = 1)
    private Set<Category> categories= new HashSet<>();

    @NotNull
    @Size(min = 500)
    private String content;
    
    @Column()
    private LocalDateTime created;

    private LocalDateTime updated;

    @PrePersist //nadanie wartosci czasowej PRZED zapisem
    public void prePersist(){
        created= LocalDateTime.now();
    }
    @PreUpdate //nadanie wartosci czasowej PRZED zmiana
    public void preUpdate(){
        updated=LocalDateTime.now();
    }



    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", categories='" + categories + '\'' +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
