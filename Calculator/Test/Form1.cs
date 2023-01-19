namespace Test
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnCopy_Click(object sender, EventArgs e)
        {
            Clipboard.SetText(txtDisplay.Text);
        }

        private void btnReset_Click(object sender, EventArgs e)
        {
            previousOperation = Operation.None;
            txtDisplay.Clear();
        }

        private void btnClear_Click(object sender, EventArgs e)
        {
            if (txtDisplay.Text.Length > 0)
            {
                double d;
                if (!double.TryParse(txtDisplay.Text[txtDisplay.Text.Length - 1].ToString(), out d))
                {
                    previousOperation = Operation.None;
                }
                
                txtDisplay.Text = txtDisplay.Text.Remove(txtDisplay.Text.Length - 1, 1);
            }
        }

        private void btnDivide_Click(object sender, EventArgs e)
        {
            if (previousOperation != Operation.None)
                PerformCalculation(previousOperation);

            previousOperation = Operation.Divide;
            txtDisplay.Text += (sender as Button).Text;
        }

        private void btnTimes_Click(object sender, EventArgs e)
        {
            if (previousOperation != Operation.None)
                PerformCalculation(previousOperation);

            previousOperation = Operation.Times;
            txtDisplay.Text += (sender as Button).Text;
        }

        private void btnMinus_Click(object sender, EventArgs e)
        {
            if (previousOperation != Operation.None)
                PerformCalculation(previousOperation);

            previousOperation = Operation.Minus;
            txtDisplay.Text += (sender as Button).Text;
        }

        private void btnPlus_Click(object sender, EventArgs e)
        {
            if (previousOperation != Operation.None)
                PerformCalculation(previousOperation);


            previousOperation = Operation.Plus;
            txtDisplay.Text += (sender as Button).Text;
        }
        List<float> lstNums = new List<float>();
        private void PerformCalculation(Operation previousOperation)
        {
            
            switch (previousOperation)
            {
                case Operation.Plus:
                    try
                    {
                        lstNums = txtDisplay.Text.Split('+').Select(float.Parse).ToList();
                        txtDisplay.Text = (lstNums[0] + lstNums[1]).ToString();
                        lstNums[0] = float.Parse(txtDisplay.Text);
                    }
                    catch(Exception e)
                    {
                        txtDisplay.Text = txtDisplay.Text.Remove(txtDisplay.Text.Length - 1, 1);
                    }
                    break;
                case Operation.Minus:
                    try
                    {
                        lstNums = txtDisplay.Text.Split('-').Select(float.Parse).ToList();
                        txtDisplay.Text = (lstNums[0] - lstNums[1]).ToString();
                        lstNums[0] = float.Parse(txtDisplay.Text);
                    }
                    catch (Exception e)
                    {
                        txtDisplay.Text = txtDisplay.Text.Remove(txtDisplay.Text.Length - 1, 1);
                    }
                    break;
                case Operation.Divide:
                        try
                        {
                            lstNums = txtDisplay.Text.Split('/').Select(float.Parse).ToList();
                            txtDisplay.Text = (lstNums[0] / lstNums[1]).ToString();
                            lstNums[0] = float.Parse(txtDisplay.Text);

                        }
                        catch (DivideByZeroException)
                        {
                            txtDisplay.Text = "EEEEEE";

                        }
                        catch (Exception e)
                        {
                            txtDisplay.Text = txtDisplay.Text.Remove(txtDisplay.Text.Length - 1, 1);
                        }               
                    break;

                case Operation.Times:
                    try
                    {
                        lstNums = txtDisplay.Text.Split('*').Select(float.Parse).ToList();
                        txtDisplay.Text = (lstNums[0] * lstNums[1]).ToString();
                        lstNums[0] = float.Parse(txtDisplay.Text);
                    }
                    catch (Exception e)
                    {
                        txtDisplay.Text = txtDisplay.Text.Remove(txtDisplay.Text.Length - 1, 1);
                    }
                    break;

                case Operation.Equals:
                    try
                    {
                        lstNums[0] = float.Parse(txtDisplay.Text);
                    }
                    catch (Exception e)
                    {
                        txtDisplay.Text = "Error has Occurred";
                    }
                    break;
                case Operation.None:
                    break;
                default:
                    break;

            }
        }

        private void btnNum_Click(object btn, EventArgs e)
        {
            txtDisplay.Text += (btn as Button).Text;
        }

        enum Operation
        {
            Plus,
            Minus,
            Times,
            Divide,
            Equals,
            None
        }
        Operation previousOperation = Operation.None;
        

        private void btnEquals_Click(object sender, EventArgs e)
        {
            if (previousOperation != Operation.None)
            PerformCalculation(previousOperation);

            previousOperation = Operation.Equals;

        }
    }
}
