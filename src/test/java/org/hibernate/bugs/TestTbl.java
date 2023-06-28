package org.hibernate.bugs;

import javax.persistence.*;

@Entity
@Table(name = "test")
public class TestTbl {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "job_id")
	private Long jobId;
}
