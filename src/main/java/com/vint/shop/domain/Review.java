package com.vint.shop.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "user_id")
    private User user;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "product_id")
    private Product product;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="created_at")
    private String created_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return getId() == review.getId() && Objects.equals(getUser(), review.getUser()) && Objects.equals(getProduct(), review.getProduct()) && Objects.equals(getTitle(), review.getTitle()) && Objects.equals(getContent(), review.getContent()) && Objects.equals(getCreated_at(), review.getCreated_at());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getProduct(), getTitle(), getContent(), getCreated_at());
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + product +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
