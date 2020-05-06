abstract class KoltsegDecorator implements IKoltseg
{
    protected IKoltseg koltseg;
    public KoltsegDecorator(IKoltseg koltseg) {this.koltseg = koltseg;}
}
