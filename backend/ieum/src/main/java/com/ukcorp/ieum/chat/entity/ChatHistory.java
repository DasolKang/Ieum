package com.ukcorp.ieum.chat.entity;

import com.ukcorp.ieum.care.entity.CareInfo;
import com.ukcorp.ieum.event.entity.Subject;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "CHAT_HISTORY")
public class ChatHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CHAT_HISTORY_NO")
  private Long chatHistoryNo;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CARE_NO")
  private CareInfo careInfo;

  @Lob
  @Column(name = "MESSAGE_CONTENT")
  private String messageContent;

  @Column(name = "SPEAKER")
  private Subject speaker;

  @Column(name = "LISTENER")
  private Subject listener;

  @Column(name = "EMOTION")
  private String emotion;

  @Column(name = "CAHT_DATE")
  @CreationTimestamp
  private LocalDateTime chatDate;

}
