import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { HueSaturationEffectComponent } from './hue-saturation-effect/hue-saturation-effect.component';
import { FormsModule } from '@angular/forms';
import { NavbarComponent } from './navbar/navbar.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { HomeComponent } from './home/home.component';
import { LogsComponent } from './logs/logs.component';
import { BrightnessComponent } from './brightness/brightness.component';
import { ContrastComponent } from './contrast/contrast.component';
import { DominantColourComponent } from './dominant-colour/dominant-colour.component';
import { FlipComponent } from './flip/flip.component';
import { GaussianBlurComponent } from './gaussian-blur/gaussian-blur.component';
import { GrayscaleComponent } from './grayscale/grayscale.component';
import { InvertComponent } from './invert/invert.component';
import { RotationComponent } from './rotation/rotation.component';
import { SepiaComponent } from './sepia/sepia.component';
import { SharpenComponent } from './sharpen/sharpen.component';

@NgModule({
  declarations: [
    AppComponent,
    HueSaturationEffectComponent,
    NavbarComponent,
    HomeComponent,
    LogsComponent,
    BrightnessComponent,
    ContrastComponent,
    DominantColourComponent,
    FlipComponent,
    GaussianBlurComponent,
    GrayscaleComponent,
    InvertComponent,
    RotationComponent,
    SepiaComponent,
    SharpenComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatToolbarModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
