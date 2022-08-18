package org.rinky.digitalassistant.bot.io;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
  Event findById(long id);
}