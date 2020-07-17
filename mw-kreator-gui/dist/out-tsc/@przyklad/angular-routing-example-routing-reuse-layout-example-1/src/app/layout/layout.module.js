import * as tslib_1 from "tslib";
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainLayoutComponent } from './main-layout/main-layout.component';
import { FooterOnlyLayoutComponent } from './footer-only-layout/footer-only-layout.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { RouterModule } from '@angular/router';
import { FlexLayoutModule } from '@angular/flex-layout';
var LayoutModule = /** @class */ (function () {
    function LayoutModule() {
    }
    LayoutModule = tslib_1.__decorate([
        NgModule({
            imports: [
                CommonModule,
                RouterModule.forChild([]),
                FlexLayoutModule
            ],
            exports: [
                MainLayoutComponent,
                FooterOnlyLayoutComponent
            ],
            declarations: [
                MainLayoutComponent,
                FooterOnlyLayoutComponent,
                FooterComponent,
                HeaderComponent,
                SidebarComponent
            ]
        })
    ], LayoutModule);
    return LayoutModule;
}());
export { LayoutModule };
//# sourceMappingURL=layout.module.js.map