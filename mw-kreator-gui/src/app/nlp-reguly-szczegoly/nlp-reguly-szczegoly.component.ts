import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RegulyService } from '../reguly.service'
import { Regula } from '../model';
@Component({
  selector: 'app-nlp-reguly-szczegoly',
  templateUrl: './nlp-reguly-szczegoly.component.html',
  styleUrls: ['./nlp-reguly-szczegoly.component.css']
})
export class NlpRegulySzczegolyComponent implements OnInit {

  constructor(private route: ActivatedRoute, private regulyUsluga: RegulyService) { }

  public regula: Regula;

  ngOnInit() {
    this.getRegula();
  }

  getRegula(): Regula {

    this.route.queryParams.subscribe(params => {
      let pKod: string; pKod = params.kod;
      this.regulyUsluga.podajRegulePoKodzie(pKod).subscribe(aRegula => {
        this.regula = aRegula;
      });
    });
    return this.regula;
  }



}
