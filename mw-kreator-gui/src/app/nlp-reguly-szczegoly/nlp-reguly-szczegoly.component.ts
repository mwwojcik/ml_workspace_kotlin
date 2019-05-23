import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-nlp-reguly-szczegoly',
  templateUrl: './nlp-reguly-szczegoly.component.html',
  styleUrls: ['./nlp-reguly-szczegoly.component.css']
})
export class NlpRegulySzczegolyComponent implements OnInit {

  constructor(private route: ActivatedRoute) { }
  private sub: any;
  kod:string

  ngOnInit() {
    //this.kod=this.route.snapshot.params.kod

    
      this.sub = this.route.queryParams.subscribe(params => {
      this.kod=params['kod']

    //this.kod=this.route.snapshot.queryParams["kod"];
    //this.kod= +params['kod'];
        });
  }
  getKod(): string {
    //const pKod =this.route.snapshot.queryParams["kod"];
    console.log("getKod")
    return this.kod;
  }
}
