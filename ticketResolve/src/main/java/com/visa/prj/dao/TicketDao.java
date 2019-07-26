package com.visa.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.prj.entity.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Integer> {

}

