import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HueSaturationEffectComponent } from './hue-saturation-effect/hue-saturation-effect.component';
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

const routes: Routes = [
  { path: 'hue-saturation', component: HueSaturationEffectComponent },
  { path: 'brightness', component: BrightnessComponent },
  { path: 'contrast', component: ContrastComponent },
  { path: 'flip', component: FlipComponent },
  { path: 'gaussian-blur', component: GaussianBlurComponent },
  { path: 'grayscale', component: GrayscaleComponent },
  { path: 'invert', component: InvertComponent },
  { path: 'rotation', component: RotationComponent },
  { path: 'sepia', component: SepiaComponent },
  { path: 'sharpen', component: SharpenComponent },
  { path: 'dominant-colour', component: DominantColourComponent },
  { path: 'logs', component: LogsComponent },
  { path: 'home', component: HomeComponent },
  { path: '', component: HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
