package hunre.it.books.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_sach")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "ma_sach")
  private String maSach;

  @Column(name = "ten_sach")
  private String tenSach;

  @Column(name = "ten_danh_muc")
  private String tenDanhMuc;

  @Column(name = "gia_sach")
  private Float giaSach;

  private String tinhTrang;

}
