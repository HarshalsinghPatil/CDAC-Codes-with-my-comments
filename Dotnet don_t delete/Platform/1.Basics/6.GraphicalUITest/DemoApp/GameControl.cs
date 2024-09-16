using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;

namespace DemoApp
{
    public class GameControl : Control
    {
        private static Random rdm = new Random();

        public static readonly DependencyProperty RadiusProperty =
            DependencyProperty.Register("Radius", typeof(int), typeof(GameControl));
        
        public int Radius
        {
            get { return (int) (GetValue(RadiusProperty) ?? 10); }
            set { SetValue(RadiusProperty, value); }
        }

        public static readonly DependencyProperty OutcomeProperty = 
            DependencyProperty.Register("Outcome", typeof(string), typeof(GameControl));
        
        public string Outcome
        {
            get { return (string) GetValue(OutcomeProperty); }
            set { SetValue(OutcomeProperty, value); }
        }

        public static readonly DependencyProperty TotalProperty =
            DependencyProperty.Register("Total", typeof(int), typeof(GameControl));
        
        public int Total
        {
            get { return (int) (GetValue(TotalProperty) ?? 0); }
            set { SetValue(TotalProperty, value); }
        }

        protected override void OnRender(DrawingContext drawingContext)
        {
            var story = new DoubleAnimation(Radius, 10, TimeSpan.FromSeconds(5))
            {
                AutoReverse = true,
                RepeatBehavior = new RepeatBehavior(1) //RepeatBehavior.Forever
            };
            var anim = story.CreateClock();
            var center = new Point(RenderSize.Width / 2, RenderSize.Height / 2);
            drawingContext.DrawEllipse(Brushes.Blue, new Pen(Brushes.Red, 10), center, null, Radius, anim, Radius, anim);
        }

        protected override void OnMouseLeftButtonUp(MouseButtonEventArgs e)
        {
            int amount = rdm.Next(-99, 100);
            Total += amount;
            if(amount >= 0)
            {
                Outcome = $"You won \u20b9{amount}";
                InvalidateVisual();
            }
            else
            {
                Outcome = $"You lost \u20b9{-amount}";
            }
        }
    }

    

}
