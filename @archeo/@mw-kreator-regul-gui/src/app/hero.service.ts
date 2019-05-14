import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { MessageService } from './message.service';

import { Hero } from './hero';
import { HEROES } from './mock-heroes';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class HeroService {

  private heroesUrl = 'http://localhost:8080/hero';

  constructor(
  private http: HttpClient,
  private messageService: MessageService) { }

  getHeroes(): Observable<Hero[]> {
     this.messageService.add('HeroService: fetched heroes');
     return this.http.get<Hero[]>(this.heroesUrl);
  }

  getHero(id: number): Observable<Hero> {
  // TODO: send the message _after_ fetching the hero
    this.messageService.add(`HeroService: fetched hero id=${id}`);
    return of(HEROES.find(hero => hero.id === id));
  }

  private log(message: string) {
    this.messageService.add(`HeroService: ${message}`);
  }

}
