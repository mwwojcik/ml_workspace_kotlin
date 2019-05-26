import { Component, OnInit,Input } from '@angular/core';
import { Router, NavigationEnd } from "@angular/router";

@Component({
  selector: 'app-uklad-glowny-app',
  templateUrl: './uklad-glowny-app.component.html',
  styleUrls: ['./uklad-glowny-app.component.css']
})
export class UkladGlownyAppComponent implements OnInit {
  czyPrzekazywacZadanie:boolean=true;
  constructor(private router: Router) { }

  ngOnInit() {
    /* this subscription will fire always when the url changes */
  this.router.events.subscribe(val=> {

    /* the router will fire multiple events */
    /* we only want to react if it's the final active route */
    if (val instanceof NavigationEnd) {

     /* the variable curUrlTree holds all params, queryParams, segments and fragments from the current (active) route */
     let curUrlTree = this.router.parseUrl(this.router.url);

     if(curUrlTree.queryParams['tryb']=='init'){
       this.czyPrzekazywacZadanie=false

     }else{
       this.czyPrzekazywacZadanie=true

     }
      console.log(this.czyPrzekazywacZadanie)
     //console.info(curUrlTree.queryParams['tryb'])
     //console.info(curUrlTree);
    }
  });
  }

}
