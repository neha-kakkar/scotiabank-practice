package com.scotiabank.practice.Controller;

import javax.persistence.*;

@Entity
@Table(name="MY_TASK")
    class Task {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        private Long id;

        @Column(name = "DESCRIPTION")
        private String description;

        @Column(name = "PRIORITY")
        private Long priority;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Long getPriority() {
            return priority;
        }

        public void setPriority(Long priority) {
            this.priority = priority;
        }

    }

