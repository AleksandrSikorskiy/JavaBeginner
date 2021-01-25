package org.example;

import javax.sound.midi.*;

class StaticSuper {
    static {
        System.out.println("Static in class StaticSuper");
    }
    StaticSuper() {

        System.out.println("StaticSuper родительский конструктор");
    }
}

class StaticTests extends StaticSuper {
    static  int rand;
    static {
        System.out.println("Static in class extends StaticSTest");
    }
    StaticTests() {

        System.out.println("StaticTests наследуемый конструктор");
    }
    public static void main(String [] args) {
//            try {
//                Sequencer sequencer = MidiSystem.getSequencer();
//                sequencer.open();
//                Sequence seq = new Sequence(Sequence.PPQ,4);
//                Track t = seq.createTrack();
//                ShortMessage a = new ShortMessage();
//                a.setMessage(144,1,44,100);
//                MidiEvent noteOn = new MidiEvent(a,1);
//                t.add(noteOn);
//                sequencer.setSequence(seq);
//                sequencer.start();
//                System.out.println("Est Midi");
//            } catch (MidiUnavailableException ex) {
//                System.out.println("No Midi");
//
//            }
        System.out.println("Main");
        StaticTests st=new StaticTests();
    }

}

